import math

def regression(filename, complexity):
    """
    Calculates an average value for the time complexity based on data points from a file.
    To approximate the coefficients of the polynomial T(n) that best explain the observed measurements.

    Args:
        filename (str): The name of the file containing data points in the format "n,t".
                        Each pair represents an input size 'n' and the corresponding time 't'.
        complexity (str): The type of complexity to calculate
                          Either 'linear' or 'quadratic'.

    Returns:
        float: The average value of the ratio according to the complexity,
               which approximates the coefficient of the polynomial T(n).

    Raises:
        ValueError: If an unknown complexity type is provided.
    """
    values = []  

    with open(filename, 'r') as file:
        lst = file.read().split(" ")
        
        # Process each data point (input size and execution time) to approximate the coefficients
        for i in range(len(lst)):
            line = lst[i].split(",")  
            n, t = int(line[0]), int(line[1]) 
            
            # Calculate the ratio based on the specified complexity to approximate the coefficient
            if complexity == "linear":
                values.append(t/n)  
            elif complexity == "quasi-linear":
                values.append(t/(n*math.log(n))) 
            elif complexity == "quadratic":
                values.append(t/n**2)  
            elif complexity == "factorial":
                values.append(t/math.factorial(n))
            else:
                raise ValueError(f"Unknown complexity: {complexity}")
    
    # Calculate and return the average of the computed ratios to estimate the coefficient
    return sum(values) / len(values)

if __name__ == '__main__':
    filename = 'rapports/fusion/aleatoire.txt'
    complexity = 'quasi-linear'  # Choose between 'linear', 'quasi-linear' or 'quadratic' or 'factorial'
    print(regression(filename, complexity))
