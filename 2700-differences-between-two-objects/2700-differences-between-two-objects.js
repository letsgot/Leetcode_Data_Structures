/**
 * @param {object} obj1
 * @param {object} obj2
 * @return {object}
 */
function objDiff(obj1, obj2) {
 // If the objects are identical, return an empty object.
  if (obj1 === obj2) return {};

  // If either object is null, return an array containing both objects.
  if (obj1 === null || obj2 === null) {
    return [obj1, obj2];
  }

  // If either object is not an object type, return an array containing both objects.
  if (typeof obj1 !== 'object' || typeof obj2 !== 'object') {
    return [obj1, obj2];
  }

  // If the objects have different array types, return an array containing both objects.
  if (Array.isArray(obj1) !== Array.isArray(obj2)) {
    return [obj1, obj2];
  }

  // Create an empty object to store the differences.
  const returnObject = {};

  // Iterate over the keys of obj1.
  for (const key in obj1) {
    // Check if the key exists in obj2.
    if (key in obj2) {
      // Recursively call objDiff on the corresponding values in obj1 and obj2.
      const subDiff = objDiff(obj1[key], obj2[key]);

      // If the subDiff has differences, store it in the returnObject.
      if (Object.keys(subDiff).length > 0) {
        returnObject[key] = subDiff;
      }
    }
  }

  // Return the object containing the differences.
  return returnObject;
}

