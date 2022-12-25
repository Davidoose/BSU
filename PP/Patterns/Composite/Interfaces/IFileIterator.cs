namespace Composite.Interfaces
{
    public interface IFileIterator
    {
        bool HasNext();
        IFileComponent Next();
        void Reset();
    }
}
