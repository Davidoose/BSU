using Composite.Interfaces;

namespace Composite.Components
{
    public class Folder : IFileComponent
    {
        public List<IFileComponent> Components { get; private set; } = new();
        public string Name { get; set; }

        public Folder(string name)
        {
            Name = name;
        }

        public void Display()
        {
            Console.WriteLine(Name);
            foreach (var component in Components)
            {
                component.Display();
            }
        }

        public void AddComponent(IFileComponent fileComponent)
        {
            Components.Add(fileComponent);
        }

        public void RemoveComponent(IFileComponent fileComponent)
        {
            Components.Remove(fileComponent);
        }

        public void AcceptArchiving(IArchiveVisitor visitor)
        {
            visitor.Archive(this);
        }
    }
}
