using Composite.Components;

namespace Composite.Interfaces
{
    public interface IArchiveVisitor
    {
        void Archive(FileComponent fileComponent);

        void Archive(Folder folder);
    }
}
