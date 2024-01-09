'''18.2 LAB: Encryption / Decryption - Part 2 (Vigenere cipher)
For this problem, you will implement a cryptographic method, known since the 16th century. This is an exercise in string manipulation.
Alice wants to send a message to Bob, but is worried that Eve is eavesdropping and will be able to read the message. So Alice encrypts the message: She and Bob share a secret word K, called the key. Alice takes the original message M, called the plaintext, and applies an encryption algorithm E to produce the ciphertext C.
C = E ( M , K )

The ciphertext C looks like gibberish, and Eve cannot read it if she intercepts it. Moreover, even if Eve knows how the encryption algorithm works, she cannot decipher the message without the key. When Bob receives C, he uses his key K and a decryption algorithm D to recover the original plaintext
M = D ( C , K )

The Decryption and Encryption Algorithms
There are many encryption algorithms and approaches. The one we will implement for this lab is called the Vigenere cipher and it was invented in the 16th century by someone name Bellaso. (Vigenere was another cryptography researcher in the 16th century. The misattribution is one of those historical errors that just stuck, and everyone calls it the Vigenere cipher.) Here is how it works:
Alice first writes the plaintext message simply as a sequence of letters, removing all spaces and punctuation and capitalization. So if the message is
We're having a surprise birthday party!
Alice will first transform it into
werehavingasurprisebirthdayparty

The shared key is some short string, let's say 'birthday'. Eve begins by writing
Message
The trick is to shift each plaintext letter by an amount equal to the position of the corresponding key letter in the alphabet. So if the key letter is 'a', then the plaintext letter is not changed at all, but if the key letter is 'b', then the plaintext letter is shifted forward one, so that plaintext 'w' will be transformed to 'x'. If the key letter is 'f', the sixth letter of the alphabet, the plaintext letter is shifted forward 5, so that 'd' becomes 'i'. What if the key letter is 'f' and the plaintext letter is 'w'? We can't shift forward 5 places, so we wrap around after 'z', and get 'b'.
Once Alice computes all the shifts she has
xmixodvgoorlbsrgtmsbywhbbggtywy

This is the ciphertext Bob receives. To decrypt it, he lines up copies of the key, 'birthdaybirthday….' under the ciphertext, and repeats the process, but in reverse, shifting backwards instead of forwards, and recovers the string
werehavingasurprisebirthdayparty
Although spaces and punctuation are missing, this is quite readable.

Instructions
You will need to begin by implementing certain functions that perform the encryption and decryption. The core of it all is the basic shift function, which I will give you here:
def shift(ch,k):
    return chr(ord('a')+(ord(ch)-ord('a')+k)%26)

Here ch is a character and k is an integer, the shift amount, so that shift('w',5) will return 'b', and shift('b',-5) will return 'w'. We'll talk in class about what all the ord and chr stuff is, since you'll need to use it in the rest.
You should implement functions that call shift, for encrypting and decrypting individual characters:
char_encrypt(plaintextchar,keychar)
char_decrypt(ciphertextchar,keychar)
so that charencrypt('w','f') returns 'b', and chardecrypt('b','f') returns 'w'.

We have provided you with the following pre_process function that gets rid of all spaces and punctuation and converts all characters to lowercase.
pre_process("We're having a surprise birthday party for Eve next Saturday night.")
returns
'werehavingasurprisebirthdaypartyforevenextsaturdaynight'

We have also provided you with the following repeattoatleastlength function that makes the key the same length as the plaintext message.
repeat_to_at_least_length("birthday", 55)
returns
'birthdaybirthdaybirthdaybirthdaybirthdaybirthdaybirthda'

Finally, put the pieces together to write the encryption and decryption algorithms
vig_encrypt(plaintext,key)
vig_decrypt(ciphertext,key)

For instance
vig_encrypt("We're having a surprise birthday party for Eve next Saturday night.","birthday")
returns the string
'xmixodvgoorlbuppjavuputfeipihutwgwixchncybjtaxrbbgebnkt'

and
     vig_decrypt('xmixodvgoorlbuppjavuputfeipihutwgwixchncybjtaxrbbgebnkt','birthday')
returns the string
'werehavingasurprisebirthdaypartyforevenextsaturdaynight'

None of these functions is very long, and some of it is quite repetitive, since char_encrypt and char_decrypt are almost identical, and vig_decrypt and vig_encrypt are almost identical except for the inclusion of a pre-processing step in vig_encrypt.'''

import string

""" The function takes in a string, makes all characters lowercase, and removes all punctuation including space.
This function should be called by vig_encrypt before encryption. """
def preprocess(plaintext):
    translator=str.maketrans('','',string.punctuation)
    plaintext=plaintext.translate(translator).lower()
    return plaintext.lower().replace(" ", "")

""" This function repeats the key so it aligns with the message that needs to be encrypted """
def repeat_to_at_least_length(key, length):
    return key * (length//len(key) + 1)

""" Given the character 'ch' and an integer k,
    representing the number of positions to shift this character,
    return the result of shifting 'ch' by 'k' positions"""
def shift(ch,k):
     return chr(ord('a')+( ord(ch)-ord('a')+k)%26)

""" Given a plain text character and a key character, it calls
    the shift function to generated the encrypted character""" 
def char_encrypt(plaintextchar,keychar):
    encrypt = shift(plaintextchar, ord(keychar) - ord('a'))
    
    return encrypt

""" Given a plain text character and a key character, it calls
the shift function to generated the decrypted character """
def char_decrypt(ciphertextchar,keychar):
    decrypt = shift(ciphertextchar, -(ord(keychar) - ord('a')))
    
    return decrypt
    
""" Encrypt with Vigenere cipher """
def vig_encrypt(plaintext,key):
    plaintext = preprocess(plaintext)
    key = repeat_to_at_least_length(key, len(plaintext))
    
    text = ""
    for i in range(len(plaintext)):
        text += char_encrypt(plaintext[i], key[i])
        
        # encrypt = char_encrypt(plaintext[i], key[i])
        # text.append(encrypt)
    
    return text
   
""" Decrypt with Vigenere cipher """
def vig_decrypt(ciphertext,key):
    key = repeat_to_at_least_length(key, len(ciphertext))
    
    text = ""
    for i in range(len(ciphertext)):
        text += char_decrypt(ciphertext[i], key[i])

        # decrypt = char_decrypt(ciphertext[i], key[i])
        # text.append(decrypt)
    
    return text