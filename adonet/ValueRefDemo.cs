// ValueRefDemo.cs
using System;

namespace UniqueAdoNetExercises
{
    class QuantumParticle
    {
        public string State { get; set; }
    }

    class Program
    {
        static void ModifyValue(int val) => val = 999;
        static void ModifyRef(QuantumParticle particle) => particle.State = "Collapsed";

        static void Main()
        {
            int superpositionValue = 42;
            var particle = new QuantumParticle { State = "Unobserved" };

            Console.WriteLine($"Original value: {superpositionValue} (0x{superpositionValue:X})");
            Console.WriteLine($"Original state: {particle.State}");

            ModifyValue(superpositionValue);
            ModifyRef(particle);

            Console.WriteLine($"After method - value: {superpositionValue} (unchanged)");
            Console.WriteLine($"After method - state: {particle.State} (modified)");

            // Demonstrate string interning
            string s1 = "Quantum";
            string s2 = "Quantum";
            Console.WriteLine($"\nString reference equality: {ReferenceEquals(s1, s2)}");
        }
    }
}