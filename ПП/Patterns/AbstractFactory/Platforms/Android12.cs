using AbstractFactory.Actions;
using AbstractFactory.Interfaces;
using AbstractFactory.Options;
using AbstractFactory.SuperActions;

namespace AbstractFactory.Platforms
{
    public class Android12 : IPlatform
    {
        public IAction Action => new Android12Action();

        public ISuperAction SuperAction => new Android12SuperAction();

        public IOptions Options => new Android12Options();
    }
}
