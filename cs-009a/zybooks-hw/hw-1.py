'''5.1 HW1
Homework Description
In this homework assignment, you will use the concepts of branching to identify the type of iris flower based on some key characteristics or attributes.

Iris Flower
Figure 1 Iris (Source:Wikipedia)
Data science/ computing techniques are important tools for botanists to automatically identify flowers based on important features. Specifically, data science techniques called classification techniques are used for this type of problem solving. A classification technique groups data points into categories or classes using a classifier.

In this assignment, we will try to classify flowers that belong to the genus iris. According to Wikipedia “Iris is a genus of 260–300 species of flowering plants with showy flowers. It takes its name from the Greek word for a rainbow, which is also the name for the Greek goddess of the rainbow, Iris.”[1] Botanists have used the following measurements to identify the specific type of iris flower. Note that, in general, such measurements or descriptive values are also called attributes.
sepal width (in cm)
petal length (in cm)
petal width (in cm)

For this assignment, we write a series of if-else operations to determine the iris type based on the given sepal and petal measurements of a given flower. We will use the classifier derived by the prominent statistician R.A. Fisher [2] and the published dataset on iris to generate the classifier that will guide us to classifying the following types of Iris flowers.
Iris-Setosa
Iris-Versicolor
Iris-Virginica

Figure 2 outlines the classifier that we need to build to correctly classify iris flowers into Setosa, Versicolor or Virginica.
Decision Tree

Figure 2 Decision Tree using the Iris training dataset
Assignment

You are asked to write a program to prompt the user for the flower features (1) sepal width (2) petal length (3) petal width and then output the flower classification (either Setosa, Versicolor, or Virginica).
Your program should define a function that will take the three features as input (arguments) and returns the flower classification.

Example Output
Enter the sepal width (cm):  3.5
Enter the petal length (cm): 1.4
Enter petal width (cm): 0.2
The flower classification is Setosa

References
[1] https://www.wikiwand.com/en/Iris_(plant)
[2] https://scikit-learn.org/dev/datasets/toy_dataset.html#wine-dataset'''

def classify(swidth, plength, pwidth):  # function returns either 'Setosa', 'Versicolor', or 'Virginica'
    # include your code here
    if pwidth <= 0.8:
        return 'Setosa'

    else:
        if plength <= 4.95:
            if pwidth <= 1.65:
                return 'Versicolor'
            else:
                if swidth <= 3.1:
                    return 'Virginica'
                else:
                    return 'Versicolor'
        else:
            if pwidth <= 1.75:
                if pwidth <= 1.65:
                    return 'Virginica'
                else:
                    return 'Versicolor'
            else:
                return 'Virginica'
    return 'FIXME'

# Do not change code below this line
if __name__ == '__main__':
    swidth = float(input('Enter the sepal width (cm): '))
    plength = float(input('Enter the petal length (cm): '))
    pwidth = float(input('Enter petal width (cm): '))
    
    result = classify (swidth, plength, pwidth)
    print (f'\nThe flower classification is {result}')