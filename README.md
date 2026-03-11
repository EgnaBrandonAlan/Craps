# Craps

A simple console-based Craps game written in Java.

**Requires:** Java 11 or newer.

## How to run

### Method 1

1. Download `Craps_v1.0.1.jar` from the [v1.0.1](https://github.com/EgnaBrandonAlan/Craps/releases/tag/v1.0.1) release page
2. Run:
   ```bash
   java -jar Craps_v1.0.1.jar
   ```

### Method 2

1. Compile the source files in `src/`:
   ```bash
   javac -d out src/*.java
   ```
2. Copy `instructions.txt` into `out/`:
   ```bash
   cp src/instructions.txt out/
   ```
3. Run the program using the compiled classes in `out/`:
   ```bash
   java -cp out Craps
   ```

### Method 3

1. Follow steps 1-2 from **Method 2**
2. Create an executable `Craps.jar`:
   ```bash
   jar cfe Craps.jar Craps -C out .
   ```
3. Run the executable `Craps.jar`:
   ```bash
   java -jar Craps.jar
   ```