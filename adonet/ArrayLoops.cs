// ArrayLoops.cs
using System;

namespace UniqueAdoNetExercises
{
    class Program
    {
        static void Main()
        {
            int[] quantumNumbers = { 2, 8, 18, 32, 50, 72, 98, 128 };
            
            Console.WriteLine("for loop (even indices only):");
            for (int i = 0; i < quantumNumbers.Length; i += 2)
            {
                Console.WriteLine($"Index {i}: {quantumNumbers[i]}");
            }

            Console.WriteLine("\nforeach loop (all elements):");
            foreach (var num in quantumNumbers)
            {
                if (num > 50) continue;
                Console.WriteLine(num);
            }

            Console.WriteLine("\nwhile loop (until value > 32):");
            int j = 0;
            while (j < quantumNumbers.Length && quantumNumbers[j] <= 32)
            {
                Console.WriteLine(quantumNumbers[j++]);
            }

            Console.WriteLine("\ndo-while loop (reverse order):");
            int k = quantumNumbers.Length - 1;
            do
            {
                Console.WriteLine(quantumNumbers[k]);
            } while (--k >= 0);
        }
    }
}