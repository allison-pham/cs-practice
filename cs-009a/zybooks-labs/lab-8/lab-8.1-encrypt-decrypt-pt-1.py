'''18.1 LAB: Encryption / Decryption - Part 1 (Cesar cipher)

Description: Today we will implement a simple encryption algorithm. Consider the following scenario:
Alice wants to send a message to Bob, but is worried that Eve is eavesdropping and will be able to read the message. So Alice encrypts the message: Alice takes the original message M, called the plaintext, and applies an encryption algorithm E to produce the ciphertext C.
The ciphertext C looks like gibberish, and Eve cannot read it if she intercepts it. When Bob receives C, he applies the decryption algorithm to recover the original plaintext
The Decryption and Encryption Algorithms

(Step 1) Alice first writes the plaintext message simply as a sequence of letters, removing all spaces and punctuation and capitalization. So if the message is
We're having a surprise birthday party
Alice will first transform it into
werehavingasurprisebirthdayparty
(Step 2) Alice then chooses an integer value (lets say between 2 and 100) which will be used to rotate the values.
(Step 3) For each character/letter in the message, Alice will shift the letter by the value given by the int decided on in Step 2.

For example:
    If the letter is 'a' and the int is 2, then the letter is shifted forward twice to become 'c'.
    If the letter is 'z' and the int is 2, then the letter is shifted forward twice to become 'b' (circles back to the beginning).
    if the letter is 'g' and the int is 4, then the letter is shifted forward twice to become 'k'.

(Step 4) Alice sends the message to Bob. Note, even if Eve intercepts the message, we cannot read it easily.
(Step 5) Bob applies the decryption algorithm which basically shifts each letter / character backwards by the int given in Step 2.
Instructions

You will need to begin by implementing certain functions that perform the encryption and decryption. The core of it all is the basic shift function, which I will give you here:
def shift(ch,k):
    return chr(ord('a')+(ord(ch)-ord('a')+k)%26)

Here ch is a character and k is an integer, the shift amount, so that shift('w',5) will return 'b', and shift('b',-5) will return 'w'. We'll talk in class about what all the ord and chr stuff is, since you'll need to use it in the rest.

We have also provided you with the following pre_process function that gets rid of all spaces and puncuation and converts all characters to lowercase.
pre_process("We're having a surprise birthday party for Eve next Saturday night.")
returns the string
'werehavingasurprisebirthdaypartyforevenextsaturdaynight'

Finally, put the pieces together to write the encryption and decryption algorithms
encrypt(plaintext, k)
decrypt(ciphertext, k)

For instance
encrypt("We're having a surprise birthday party for Eve next Saturday night." , 3)
returns the string
'xfsfibwjohbtvsqsjtfcjsuiebzqbsuzgpsfwfofyutbuvsebzojhiu'

and

decrypt('xfsfibwjohbtvsqsjtfcjsuiebzqbsuzgpsfwfofyutbuvsebzojhiu', 3)
returns the string
'werehavingasurprisebirthdaypartyforevenextsaturdaynight'
'''

import string

""" The function takes in a string, makes all characters lowercase, and removes all punctuation including space.
This function should be called by encrypt before encryption. """
def preprocess(plaintext):
    translator=str.maketrans('','',string.punctuation)
    plaintext=plaintext.translate(translator).lower()
    return plaintext.lower().replace(" ", "")

""" Given the character 'ch' and an integer k,
    representing the number of positions to shift this character,
    return the result of shifting 'ch' by 'k' positions"""
def shift(ch,k):
     return chr(97+( ord(ch)-97+k)%26) # equivalent to chr(ord('a')+( ord(ch)-ord('a')+k)%26)

""" Encrypt with Cesar cipher """
def encrypt(plaintext,k):
    plaintext = preprocess(plaintext)
    ciphertext = ""
    
    for i in plaintext:
        ciphertext += shift(i, k)
        
    return ciphertext
   
""" Decrypt with Cesar cipher """
def decrypt(ciphertext,k):
    plaintext = ""
    
    for i in ciphertext:
        plaintext += shift(i, -k)
    
    return plaintext