def normalizing(num_list):
    # Find max_val
    # Divide each number in the list by the max_val
    max_val = max(num_list)
    updated_list = []

    for k in num_list:
        updated_list = [k / max_val]

    '''if not num_list:  # Check for empty list
        return []'''

    '''for i in num_list:
        # Find max_val
        if i > max_val:
            max_val = i'''

    '''if max_val == 0:  
        return [0] * len(num_list)'''
    
    '''for k in num_list:
        # Divide each number in the list by the max_val
        k = k / max_val
        updated_list.append(k)'''

    return updated_list

# num_list = [1, 10, 50, 100]
print(normalizing([1, 10, 50, 100]))
