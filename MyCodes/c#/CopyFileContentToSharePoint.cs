using Microsoft.SharePoint.Client;
using Microsoft.Identity.Client;
using File = Microsoft.SharePoint.Client.File;
using System.Security.Cryptography.X509Certificates;
using Environment = SPMP.azure.Environment;

namespace SharePointFileCopy
{
    class CopyFileContentToSharePoint
    {
        private const string TenantId = "******.onmicrosoft.com";
        private const string ClientId = "**************";
        private const string ClientSecret = "*****************";

        static async Task Main(string[] args)
        {
            string sourceSiteUrl = "https://******.sharepoint.com/sites/demotest123";
            string targetSiteUrl = "https://******.sharepoint.com/sites/demotest";
            string sourceFilePath = "/sites/demotest123/Shared Documents/folder/folder3/Testing_#123_%!123.txt";
            string targetFolderPath = "/sites/demotest/Documents/";

            try
            {
                Console.WriteLine("Program started.");
                string accessToken = await GetAccessTokenAsync();
                Console.WriteLine("Fetched access key");
                CopyFileWithCSOM(sourceSiteUrl, targetSiteUrl, sourceFilePath, targetFolderPath, accessToken);
                Console.WriteLine("File copied successfully.");
            }
            catch (Exception ex)
            {
                Console.WriteLine($"Error: {ex.Message}");
            }
        }

        private static async Task<string> GetAccessTokenAsync()
        {
            var certificate = new X509Certificate2("C:\\SPMP\\4504\\SharePoint Manager Plus\\conf\\certificates\\admpmsdn_SPMP_1736407100649.pfx", "be4b445b-06cc-413f-8064-864c5b31b5ab", X509KeyStorageFlags.MachineKeySet);
            var authority = Environment.GetProperty("DEFAULT", "LOGIN_URL") + "/" + TenantId + "/";

            
            var app = ConfidentialClientApplicationBuilder.Create(ClientId)
                        .WithAuthority(authority)
                        .WithCertificate(certificate)
                        .Build();

            string[] scopes = { "https://admpmsdn-admin.sharepoint.com/.default" };
            var result = await app.AcquireTokenForClient(scopes).ExecuteAsync();
            return result.AccessToken;
        }

        private static void CopyFileWithCSOM(string sourceSiteUrl, string targetSiteUrl, string sourceFilePath, string targetFolderPath, string accessToken)
        {
            using (ClientContext sourceContext = GetClientContext(sourceSiteUrl, accessToken))
            {
                using (ClientContext targetContext = GetClientContext(targetSiteUrl, accessToken))
                {
                    Console.WriteLine("MAking a request.");
                    string encodedSourceFilePath = EncodeSpecialCharacters(sourceFilePath);

                   // encodedSourceFilePath = "/sites/demotest123/Shared%20Documents/Gow_Test_!_%23_%25_/Testing_%23123_!123.txt?csf=1&web=1&e=bNn4Mf";
                   
                    //encodedSourceFilePath = "/sites/demotest123/Shared Documents/folder/folder3/ThreatStats.txt";
                    //encodedSourceFilePath = "/sites/demotest123/Shared Documents/folder/neew/users2.txt";

                   // encodedSourceFilePath = "/sites/demotest123/Shared Documents/folder/folder3/Testing_#123_%123.txt";

                    //File sourceFile = sourceContext.Web.GetFileByServerRelativeUrl(encodedSourceFilePath);
                    File sourceFile = sourceContext.Web.GetFileByServerRelativePath(ResourcePath.FromDecodedUrl(sourceFilePath));
                    sourceContext.Load(sourceFile);
                    sourceContext.ExecuteQuery();

                    ClientResult<Stream> fileStream = sourceFile.OpenBinaryStream();
                    sourceContext.ExecuteQuery();

                    string targetFileName = Path.GetFileName(sourceFilePath);
                    string targetFileUrl = $"{targetFolderPath.TrimEnd('/')}/{targetFileName}";

                    FileCollectionAddParameters fileInfo = new FileCollectionAddParameters
                    {
                        Overwrite = false
                    };

                    Folder targetFolder = targetContext.Web.GetFolderByServerRelativePath(ResourcePath.FromDecodedUrl(targetFolderPath));
                    File uploadFile = targetFolder.Files.AddUsingPath(targetFileName,fileInfo,fileStream.Value);
                    targetContext.Load(uploadFile);
                    targetContext.ExecuteQuery();
                }
            }
        }

        private static ClientContext GetClientContext(string siteUrl, string accessToken)
        {
            var clientContext = new ClientContext(siteUrl);
            clientContext.ExecutingWebRequest += (sender, e) =>
            {
                e.WebRequestExecutor.RequestHeaders["Authorization"] = "Bearer " + accessToken;
            };
            return clientContext;
        }

        private static string EncodeSpecialCharacters(string input)
        {
            return input.Replace("%", "%25").Replace("#", "%23").Replace("!", "!").Replace(" ", "%20");
        }
    }
}
