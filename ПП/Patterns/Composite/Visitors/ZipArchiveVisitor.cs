using Composite.Components;
using Composite.Interfaces;

namespace Composite.Visitors
{
    public class ZipArchiveVisitor : IArchiveVisitor
    {
        public void Archive(FileComponent fileComponent)
        {
            Console.WriteLine("Zip..");
            Console.WriteLine(fileComponent.Name);
        }

        public void Archive(Folder folder)
        {
            Console.WriteLine("Zip..");
            Console.WriteLine(folder.Name);
        }
    }
}
