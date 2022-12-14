namespace State
{
    public class DbConnection
    {
        private State _state;

        public DbConnection()
        {
            SetState(new CloseState(this));
        }

        public void Open()
        {
            _state.Open();
        }

        public void Process(string str)
        {
            _state.Process(str);
        }

        public void Close()
        {
            _state.Close();
        }

        public void SetState(State state)
        {
            _state = state;
        }
    }
}
