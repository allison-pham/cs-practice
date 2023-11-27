with open("emissions.txt", "r") as fileHandle:
    lines = fileHandle.readlines()

numReadings = len(lines)

avgEmissions = 0
totalEmissions = 0

# numObservatisons = 0
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

variance /= (numReadings - 1)

print("Variance in San Mateo County Emissions: ", variance)