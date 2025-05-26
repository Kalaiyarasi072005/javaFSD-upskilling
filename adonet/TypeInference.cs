// TypeInference.cs
using System;
using System.Collections.Generic;

namespace UniqueAdoNetExercises
{
    class Program
    {
        static void Main()
        {
            var mysteryNumber = 42; // int
            var cosmicMessage = "The answer to life, the universe, and everything";
            var celestialBodies = new List<string> { "Quasar", "Pulsar", "Neutron Star" };
            var quantumState = new { Spin = "Up", Charge = -1 };

            Console.WriteLine($"Type of mysteryNumber: {mysteryNumber.GetType().Name}");
            Console.WriteLine($"Type of cosmicMessage: {cosmicMessage.GetType().Name}");
            Console.WriteLine($"Type of celestialBodies: {celestialBodies.GetType().Name}");
            Console.WriteLine($"Type of quantumState: {quantumState.GetType().Name}");

            // Complex type inference example
            var complexInference = new[] 
            {
                new { Name = "Andromeda", Distance = 2.537M },
                new { Name = "Whirlpool", Distance = 31M }
            };

            Console.WriteLine($"\nFirst galaxy: {complexInference[0].Name} ({complexInference[0].Distance} Mly)");
        }
    }
}