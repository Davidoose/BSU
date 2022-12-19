namespace Strategy;

class Program
{
    public static void Main()
    {
        var list = new List<int> { 10, 2, -3 };

        var calculationEngine = new CalculationEngine(list);

        calculationEngine.Sort();
        calculationEngine.Print();

        var strategy = new DescendingSortStrategy();
        calculationEngine.SetStrategy(strategy);

        calculationEngine.Sort();
        calculationEngine.Print();
    }
}