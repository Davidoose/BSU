namespace Composite.Interfaces
{
    public interface IFileComponent
    {
        void Display();

        void AcceptArchiving(IArchiveVisitor visitor);
    }
}
