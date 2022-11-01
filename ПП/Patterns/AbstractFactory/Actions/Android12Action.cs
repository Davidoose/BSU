using AbstractFactory.Interfaces;

namespace AbstractFactory.Actions
{
    public class Android12Action : IAction
    {
        public void GetAction()
        {
            Console.WriteLine("Android 12 Action");
        }
    }
}
