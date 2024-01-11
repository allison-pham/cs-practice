def normalizing(num_list):
    # Find max_val
    # Divide each number in the list by the max_val
    max_val = -1
    updated_list = []

    for i in num_list:
        # Find max_val
        if i > max_val:
            max_val = i

    for k in num_list:
        # Divide each number in the list by the max_val
        k = k / max_val
        updated_list.append(k)

    return updated_list


def normalizing(num_list):
    if not num_list:  # Check for empty list
        return []

    max_val = max(num_list)
    if max_val == 0:  
        return [0] * len(num_list) 

    updated_list = [k / max_val for k in num_list]
    return updated_list

num_list = [2, 4, 6, 8, 10]
print(normalizing(num_list)) 
