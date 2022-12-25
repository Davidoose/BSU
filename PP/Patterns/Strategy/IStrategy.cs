namespace Strategy
{
    public interface IStrategy
    {
        ICollection<int> Sort(ICollection<int> list);
    }
}
