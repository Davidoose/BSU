using AbstractFactory;
using AbstractFactory.Interfaces;

class Program
{
    private static IPlatform platform;
    private static PlatformVersion version = PlatformVersion.IOS13;
    public static void Main()
    {
        platform = PlatformBuilder.CreatePlatform(version);

        IAction action = platform.Action;
        ISuperAction superAction = platform.SuperAction;
        IOptions options = platform.Options;

        action.GetAction();
        superAction.GetSuperAction();
        options.GetOptions();
    }
}