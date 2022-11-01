using AbstractFactory.Interfaces;
using AbstractFactory.Platforms;

namespace AbstractFactory
{
    public static class PlatformBuilder
    {
        public static IPlatform CreatePlatform(PlatformVersion version)
        {
            if (version == PlatformVersion.Android12)
            {
                return new Android12();
            }
            else
            {
                return new IOS13();
            }
        }
    }
}
