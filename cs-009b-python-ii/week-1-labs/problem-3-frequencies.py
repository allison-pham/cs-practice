def frequencies(word_list):
    # Track frequency of each individual word
    # Create ctr for each individual word
    # dictionary

  freq = {}
    for word in word_list:
        if word in freq:
            freq[word] += 1
        else:
            freq[word] = 1
    return freq


word_list = ["apple", "banana", "apple", "orange", "banana", "apple"]
print(frequencies(word_list))