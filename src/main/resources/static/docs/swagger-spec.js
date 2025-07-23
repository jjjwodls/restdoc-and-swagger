window.swaggerSpec={
  "openapi" : "3.0.1",
  "info" : {
    "title" : "restdocs-swagger API Documentation",
    "description" : "Spring REST Docs with SwaggerUI.",
    "version" : "0.0.1"
  },
  "servers" : [ {
    "url" : "http://localhost:8080"
  } ],
  "tags" : [ ],
  "paths" : {
    "/company" : {
      "post" : {
        "tags" : [ "Company" ],
        "summary" : "company 생성",
        "description" : "companyCreateRequest 를 통해 Company 를 생성할 수 있다.",
        "operationId" : "company-controller-test/create",
        "requestBody" : {
          "content" : {
            "application/json;charset=UTF-8" : {
              "schema" : {
                "$ref" : "#/components/schemas/CompanyCreateRequest"
              },
              "examples" : {
                "company-controller-test/create-fail" : {
                  "value" : "{\"companyName\":\"\",\"address\":\"\"}"
                },
                "company-controller-test/create" : {
                  "value" : "{\n  \"companyName\" : \"companyName\",\n  \"address\" : \"company address\"\n}"
                }
              }
            }
          }
        },
        "responses" : {
          "400" : {
            "description" : "400"
          },
          "201" : {
            "description" : "201",
            "content" : {
              "application/json" : {
                "schema" : {
                  "$ref" : "#/components/schemas/CompanyCreateResponse"
                },
                "examples" : {
                  "company-controller-test/create" : {
                    "value" : "{\n  \"id\" : 1\n}"
                  }
                }
              }
            }
          }
        }
      }
    },
    "/company/{id}" : {
      "get" : {
        "tags" : [ "Company" ],
        "summary" : "company 조회",
        "description" : "company id를 통해 정보를 조회할 수 있다.",
        "operationId" : "company-controller-test/get-company",
        "parameters" : [ {
          "name" : "id",
          "in" : "path",
          "description" : "",
          "required" : true,
          "schema" : {
            "type" : "string"
          }
        } ],
        "responses" : {
          "200" : {
            "description" : "200",
            "content" : {
              "application/json" : {
                "schema" : {
                  "$ref" : "#/components/schemas/CompanyResponse"
                },
                "examples" : {
                  "company-controller-test/get-company" : {
                    "value" : "{\"id\":1,\"companyName\":\"company name\",\"companyAddress\":\"company address\"}"
                  }
                }
              }
            }
          }
        }
      }
    }
  },
  "components" : {
    "schemas" : {
      "CompanyResponse" : {
        "title" : "CompanyResponse",
        "required" : [ "companyAddress", "companyName", "id" ],
        "type" : "object",
        "properties" : {
          "companyAddress" : {
            "type" : "string",
            "description" : "company address"
          },
          "companyName" : {
            "type" : "string",
            "description" : "company name "
          },
          "id" : {
            "type" : "number",
            "description" : "companyId"
          }
        }
      },
      "CompanyCreateResponse" : {
        "title" : "CompanyCreateResponse",
        "required" : [ "id" ],
        "type" : "object",
        "properties" : {
          "id" : {
            "type" : "number",
            "description" : "created company id"
          }
        }
      },
      "CompanyCreateRequest" : {
        "title" : "CompanyCreateRequest",
        "required" : [ "address", "companyName" ],
        "type" : "object",
        "properties" : {
          "address" : {
            "type" : "string",
            "description" : "company address"
          },
          "companyName" : {
            "type" : "string",
            "description" : "company name"
          }
        }
      }
    }
  }
}