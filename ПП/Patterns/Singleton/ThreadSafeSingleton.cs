namespace Singleton
{
    class ThreadSafeSingleton
    {
        private ThreadSafeSingleton() { }

        private static ThreadSafeSingleton _instance;

        private static readonly object _lock = new object();

        public static ThreadSafeSingleton Instance
        {
            get
            {
                if (_instance == null)
                {
                    lock (_lock)
                    {
                        _instance ??= new ThreadSafeSingleton();
                    }
                }
                return _instance;
            }
        }
    }
}
