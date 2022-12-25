namespace State
{
    public abstract class State
    {
        protected DbConnection dbConnection;

        protected State(DbConnection dbConnection)
        {
            this.dbConnection = dbConnection;
        }

        public abstract void Open();

        public abstract void Process(string str);

        public abstract void Close();
    }
}
