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
        "tags" : [ "Board" ],
        "summary" : "알림 수정",
        "description" : "update 정보를 통해 알림을 업데이트할 수 있다.",
        "operationId" : "company-controller-test/create",
        "requestBody" : {
          "content" : {
            "application/json;charset=UTF-8" : {
              "schema" : {
                "$ref" : "#/components/schemas/CompanyCreateRequest"
              },
              "examples" : {
                "company-controller-test/create" : {
                  "value" : "{\n  \"companyName\" : \"companyName\",\n  \"address\" : \"company address\"\n}"
                }
              }
            }
          }
        },
        "responses" : {
          "201" : {
            "description" : "201",
            "content" : {
              "application/json" : {
                "schema" : {
                  "$ref" : "#/components/schemas/CompanyCreateResponse"
                },
                "examples" : {
                  "company-controller-test/create" : {
                    "value" : "{\n  \"id\" : 1,\n  \"companyName\" : \"company name\",\n  \"companyAddress\" : \"company address\"\n}"
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
        "tags" : [ "Board" ],
        "summary" : "회사 조회",
        "description" : "회사 id를 통해 정보를 조회할 수 있다.",
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
                    "value" : "{\n  \"id\" : 1,\n  \"companyName\" : \"company name\",\n  \"companyAddress\" : \"company address\"\n}"
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
      },
      "CompanyCreateResponse" : {
        "title" : "CompanyCreateResponse",
        "required" : [ "companyAddress", "companyName", "id" ],
        "type" : "object",
        "properties" : {
          "companyAddress" : {
            "type" : "string",
            "description" : "created company address"
          },
          "companyName" : {
            "type" : "string",
            "description" : "created company name"
          },
          "id" : {
            "type" : "number",
            "description" : "created company id"
          }
        }
      }
    }
  }
}