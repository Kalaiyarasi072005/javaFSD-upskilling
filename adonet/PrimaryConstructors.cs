// PrimaryConstructors.cs
using System;

namespace UniqueAdoNetExercises
{
    class GalacticExplorer(string name, string ship, int missions)
    {
        public string Name { get; } = name ?? "Unknown Explorer";
        public string Ship { get; } = ship ?? "Unidentified Vessel";
        public int MissionsCompleted { get; } = missions >= 0 ? missions : 0;

        public void DisplayInfo() => 
            Console.WriteLine($"{Name} commands the {Ship} and has completed {MissionsCompleted} missions.");
    }

    class Program
    {
        static void Main()
        {
            var explorer1 = new GalacticExplorer("Zara Xenon", "Nebula Chaser", 17);
            var explorer2 = new GalacticExplorer(null, null, -5);
            
            explorer1.DisplayInfo();
            explorer2.DisplayInfo();
        }
    }
}