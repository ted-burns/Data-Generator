## Top Level Design

### Main
#### Function 
- Create new output file
  - Ability to choose directory?
- Get format for data output
- In a loop
  - Get data line
    - Generated **TBD**
  - Write data line to output file
- Close output stream

### Data Generator
#### Function
- Take parameters
- Generate line

### Decider
*I had no idea what the hell to call this class...*
#### Important notes
- Non-static
- Takes in a number between 0 and 1 (inclusive) and outputs something else depending on what bucket the number give it falls into
#### Function
- Instantiated with two arrays
  - One array has the chances for each output
    - Chances **must** collectively add up to 1
  - Other array has the outputs
  - Arrays **must** be the same length
    - Otherwise, an exception is thrown
- Receives a number between 0 and 1 (inclusive)
- Outputs a number based on the bucket
