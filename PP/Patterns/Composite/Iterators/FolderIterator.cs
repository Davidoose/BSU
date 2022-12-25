using Composite.Components;
using Composite.Interfaces;

namespace Composite.Iterators
{
    public class FolderIterator : IFileIterator
    {
        protected List<IFileComponent> files;
        protected int currentIndex;
        public FolderIterator(Folder folder)
        {
            files = folder.Components;
            currentIndex = 0;
        }

        public bool HasNext()
        {
            return currentIndex < files.Count - 1;
        }

        public IFileComponent Next()
        {
            return files[currentIndex++];
        }

        public void Reset()
        {
            throw new NotImplementedException();
        }
    }
}
