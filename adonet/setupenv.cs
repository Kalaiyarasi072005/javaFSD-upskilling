// SetupEnv.cs
using System;

namespace UniqueAdoNetExercises
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Greetings from the Quantum Realm!");
            Console.WriteLine($"Current timestamp: {DateTime.Now:yyyy-MM-dd HH:mm:ss.ffff}");
            Console.WriteLine($"Environment: {Environment.OSVersion}");
            Console.WriteLine($"64-bit process: {Environment.Is64BitProcess}");
            Console.WriteLine($"Processor count: {Environment.ProcessorCount}");
        }
    }
}