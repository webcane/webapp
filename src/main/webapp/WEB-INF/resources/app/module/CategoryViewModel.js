function arrayize(data) {
  if (angular.isArray(data)) {
    return data;
  } else {
    return [data];
  }
}

function CategoryViewModel($http) {
  this.message = "Hello World";
  this.selectedCategory = null;

  this.categories = [];

  this.selectCategory = function (category) {
    this.selectedCategory = category;
  };

  var self = this;

  $http.get('api/v1/categories')
          .then(function (result) {
            var categories = arrayize(result.data);
            categories.forEach(function (categoryPayload) {
              self.categories.push(new Category(categoryPayload));
            });
          })
          .catch(function (result) {
            console.log('Error', result);
          });
}