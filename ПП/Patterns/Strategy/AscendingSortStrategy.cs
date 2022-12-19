namespace Strategy
{
    public class AscendingSortStrategy : IStrategy
    {
        public ICollection<int> Sort(ICollection<int> list)
        {
            return list.OrderBy(i => i).ToList();
        }
    }
}
