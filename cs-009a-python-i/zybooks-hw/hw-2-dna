'''12.1 DNA Sequence
DNA, the carrier of genetic information in living things, has been used in criminal justice for decades. But how, exactly, does DNA profiling work? Given a sequence of DNA, how can forensic investigators identify to whom it belongs?
Well, DNA is really just a sequence of molecules called nucleotides, arranged into a particular shape (a double helix). Each nucleotide of DNA contains one of four different bases: adenine (A), cytosine (C), guanine (G), or thymine (T). Every human cell has billions of these nucleotides arranged in sequence. Some portions of this sequence (i.e. genome) are the same, or at least very similar, across almost all humans, but other portions of the sequence have a higher genetic diversity and thus vary more across the population.
One place where DNA tends to have high genetic diversity is in Short Tandem Repeats (STRs). An STR is a short sequence of DNA bases that tends to be repeated back-to-back numerous times at specific locations in DNA. The number of times any particular STR repeats varies a lot among different people. In the DNA samples below, for example, Alice has the STR AGAT repeated four times in her DNA, while Bob has the same STR repeated five times.

DNA Snippets
Using multiple STRs, rather than just one, can improve the accuracy of DNA profiling. If the probability that two people have the same number of repeats for a single STR is 5%, and the analyst looks at 10 different STRs, then the probability that two DNA samples match purely by chance is about 1 in 1 quadrillion (assuming all STRs are independent of each other). So if two DNA samples match in the number of repeats for each of the STRs, the analyst can be pretty confident they came from the same person. CODIS, The FBI's DNA database, uses 20 different STRs as part of its DNA profiling process.

TASK Define a function named computeLCS that receives a long DNA sequence and a STR (like AGAT, AATG, or TATC). The function returns the number of times the STR is repeated back-to-back within the DNA sequence. This is a core function that can be used in DNA profiling as discussed above.
# Define a function to compute longest consecutive sequence 
def computeLCS(dna_sequence, STR):
    # TODO - compute and return  the longest consecutive occurrence  

if __name__ == "__main__" :   
    dna_sequence = input()     # obtain DNA sequence 
    STR = input()     # obtain STR from input  (ex. AGAT ) 

    # compute the number of consecutive occurrence of STR in the string dna_sequence 
    print (computeLCS (dna_sequence, STR) )'''

# Define your function here 
def computeLCS(dna_sequence, STR):
    #TODO - your code goes here
    count = 0
    i = 0
    maxNum = 0
    
    while i < len(dna_sequence):
    # for i in range(len(dna_sequence) - len(STR) + 1):
        if dna_sequence[i:len(STR) + i] == STR:
            count += 1
            i += len(STR)
            # If the next set of 'DNA strand' is equal to STR, then the program needs to skip the rest of the checking
            if count > maxNum:
                maxNum = count
        # Check if it's back-to-back
        else: # Not back-to-back
            count = 0
            i += 1
    
    return maxNum
        
if __name__ == "__main__" :   
    
    dna_sequence = input()     # obtain DNA sequence 
    STR = input()     # obtain STR from input  (ex. AGAT ) 

    # call function to compute the number of consecutive (back-to-back) occurrence of STR in the string dna_sequence 
    print (computeLCS (dna_sequence, STR) )  