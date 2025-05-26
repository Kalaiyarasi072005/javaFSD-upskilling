// GradeCalculator.cs
using System;

namespace UniqueAdoNetExercises
{
    class Program
    {
        static void Main()
        {
            Console.WriteLine("Enter your cosmic performance score (0-100):");
            if (int.TryParse(Console.ReadLine(), out int score))
            {
                string grade = score switch
                {
                    >= 90 and <= 100 => "A (Stellar Performance)",
                    >= 80 and < 90 => "B (Celestial Achievement)",
                    >= 70 and < 80 => "C (Orbital Standard)",
                    >= 60 and < 70 => "D (Gravitational Struggle)",
                    >= 0 and < 60 => "F (Black Hole of Failure)",
                    _ => "Invalid (Transdimensional Anomaly)"
                };

                Console.WriteLine($"Your grade: {grade}");
            }
            else
            {
                Console.WriteLine("Invalid input. Please enter a number between 0 and 100.");
            }
        }
    }
}