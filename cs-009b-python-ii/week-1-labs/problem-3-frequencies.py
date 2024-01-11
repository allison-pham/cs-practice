def frequencies(word_list):
    # Track frequency of each individual word
    # Create ctr for each individual word
    # dictionary
  
    frequency = {}

    for word in word_list:
        if word in frequency:
            frequency[word] += 1
        else:
            frequency[word] = 1

    return frequency

word_list = ["hi", "hello", "hi"]
print(frequencies(word_list))