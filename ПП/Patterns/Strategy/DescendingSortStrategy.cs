namespace Strategy
{
    public class DescendingSortStrategy : IStrategy
    {
        public ICollection<int> Sort(ICollection<int> list)
        {
            return list.OrderByDescending(i => i).ToList();
        }
    }
}
