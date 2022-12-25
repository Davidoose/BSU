namespace Command
{
    public class LogCommand : ICommand
    {
        private string _message;

        public LogCommand(string message)
        {
            _message = message;
        }
        public void Execute()
        {
            Console.WriteLine(_message);
        }
    }
}
