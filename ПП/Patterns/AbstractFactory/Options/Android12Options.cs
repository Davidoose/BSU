using AbstractFactory.Interfaces;

namespace AbstractFactory.Options
{
    public class Android12Options : IOptions
    {
        public void GetOptions()
        {
            Console.WriteLine("Android 12 Options");
        }
    }
}
