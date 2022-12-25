namespace Strategy
{
    public class CalculationEngine
    {
        private IStrategy strategy;
        private ICollection<int> list;

        public CalculationEngine(ICollection<int> list)
        {
            this.list = list;
            strategy = new AscendingSortStrategy();
        }

        public void SetStrategy(IStrategy strategy)
        {
            this.strategy = strategy;
        }

        public void Sort()
        {
            list = strategy.Sort(list);
        }

        public void Print()
        {
            foreach (var item in list)
            {
                Console.Write(item + " ");
            }
            Console.WriteLine();
        }
    }
}
