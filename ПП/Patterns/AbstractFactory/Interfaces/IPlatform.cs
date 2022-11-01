namespace AbstractFactory.Interfaces
{
    public interface IPlatform
    {
        IAction Action { get; }
        ISuperAction SuperAction { get; }
        IOptions Options { get; }
    }
}
