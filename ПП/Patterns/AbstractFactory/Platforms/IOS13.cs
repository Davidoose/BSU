using AbstractFactory.Actions;
using AbstractFactory.Interfaces;
using AbstractFactory.Options;
using AbstractFactory.SuperActions;

namespace AbstractFactory.Platforms
{
    public class IOS13 : IPlatform
    {
        public IAction Action => new IOS13Action();

        public ISuperAction SuperAction => new IOS13SuperAction();

        public IOptions Options => new IOS13Options();
    }
}
