using Composite.Components;
using Composite.Interfaces;

namespace Composite.Visitors
{
    public class RarArchiveVisitor : IArchiveVisitor
    {
        public void Archive(FileComponent fileComponent)
        {
            Console.WriteLine("Rar..");
            Console.WriteLine(fileComponent.Name);
        }

        public void Archive(Folder folder)
        {
            Console.WriteLine("Rar..");
            Console.WriteLine(folder.Name);
        }
    }
}
