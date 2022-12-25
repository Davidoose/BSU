namespace State
{
    public class CloseStateException : Exception
    {
        public CloseStateException(string? message) : base(message)
        {
        }
    }
}
