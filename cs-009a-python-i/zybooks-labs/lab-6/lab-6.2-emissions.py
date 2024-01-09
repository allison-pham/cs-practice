'''14.2 San Mateo County Emissions Data
Note on lab submission:
You will be testing your code in another environment and then submitting a file (main.py) of this code to zybooks. In lab this week, we will show you how to create this file and test the code in this file using JupyterLab. Here is the link to JupyterLab: https://locus.cs.ucr.edu/ You will log in using your UCR netid and password.
Lab Description:
Recent US open data initiatives have meant that agencies at all levels of government have begun to publish different sets of data that they collect to meet various needs of the country, state, or municipality. Most of this data is being used to inform day-to-day operations, allow for the tracking of trends and help in long-term planning. The large amount of data and relatively few people actually looking at it, especially from multiple sources, means that there is a lot of room for developers who know how to process this information to use it to find new trends and create new services.
Start by downloading the emissions.txt file which contains a list of total emissions from various cities in San Mateo county over multiple years. This data was extracted from a larger dataset provided by the ​Open San Mateo County​ initiative.
Using this file find the total amount of emissions from all counties across all years and the average emissions and print them out with the following format.

Sample Output
Total San Mateo County Emissions: ​32699810.0
Average San Mateo County Emissions: ​259522.3015873016
The above values should be (approximately) correct but you will need to calculate them from the data in the file and use the above to validate that your calculation is correct. Once you have calculated the total and average emissions, you will need to calculate the ​variance​ of the values in the file.
The most useful equation for finding variance is below.

Computing variance
Note, you will need 1 loop to find the average emissions, and then once you have the average, loop over the data again to compute the variance. When you calculate variance, print it out in addition to the values above with the following text.

Sample Output (everything together)
Total San Mateo County Emissions: ​32699810.0
Average San Mateo County Emissions: ​259522.3015873016
Variance in San Mateo County Emissions: ​42137910766.98032'''

with open("emissions.txt", "r") as fileHandle:
    lines = fileHandle.readlines()

numReadings = len(lines)

avgEmissions = 0
totalEmissions = 0

numObservations = 0
variance = 0

for line in lines:
    emissions = float(line)
    totalEmissions += emissions
    # avgEmissions += 1


avgEmissions = totalEmissions / numReadings

print("Total San Mateo County Emissions: ", totalEmissions)
print("Average San Mateo County Emissions: ", avgEmissions)

# Variance
for line in lines:
    emissions = float(line)
    
    variance += (emissions - avgEmissions) ** 2

variance /= (numObservations - 1)

print("Variance in San Mateo County Emissions: ", variance)