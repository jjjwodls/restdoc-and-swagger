package com.example.restdoc.company;

import com.epages.restdocs.apispec.*;
import com.example.restdoc.company.dto.CompanyCreateRequest;
import com.example.restdoc.company.dto.CompanyCreateResponse;
import com.example.restdoc.company.dto.CompanyResponse;
import com.example.restdoc.company.entity.Company;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.operation.preprocess.Preprocessors;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static com.epages.restdocs.apispec.ResourceDocumentation.resource;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;

@AutoConfigureRestDocs
@WebMvcTest(CompanyController.class)
class CompanyControllerTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    private final ResourceSnippetParametersBuilder resourceBuilder = ResourceSnippetParameters.builder().tag("Board");

    @MockitoBean
    private CompanyService companyService;

    @Test
    @DisplayName("회사를 조회할 수 있다.")
    void getCompany() throws Exception {
        //given
        Company company = Company.builder().id(1L).name("company name").address("company address").build();
        Long companyId = 1L;
        given(companyService.findOne(any())).willReturn(company);
        //when
        //then
        ResultActions perform = mockMvc.perform(
                get("/company/{id}",companyId)
                        .contentType(MediaType.APPLICATION_JSON)
        );

        ConstrainedFields fields = new ConstrainedFields(CompanyResponse.class);


        perform.andDo(
                MockMvcRestDocumentationWrapper.document(
                        "{class-name}/{method-name}", // identifier
                        Preprocessors.preprocessRequest(Preprocessors.prettyPrint()),
                        Preprocessors.preprocessResponse(Preprocessors.prettyPrint()),
                        resource(resourceBuilder
                                .summary("회사 조회")
                                .description("회사 id를 통해 정보를 조회할 수 있다.")
                                .responseFields(
                                        fields.withPath("id").type(JsonFieldType.NUMBER).description("companyId"),
                                        fields.withPath("companyName").type(JsonFieldType.STRING).description("company name "),
                                        fields.withPath("companyAddress").type(JsonFieldType.STRING).description("company address")
                                )
                                .responseSchema(Schema.schema("CompanyResponse"))
                                .build())
                ));

    }

    @Test
    @DisplayName("회사를 생성할 수 있다.")
    void create() throws Exception{
        //given
        CompanyCreateRequest companyCreateRequest = CompanyCreateRequest.builder().companyName("companyName").address("company address").build();
        Company company = Company.builder().id(1L).name("company name").address("company address").build();
        given(companyService.createCompany(any())).willReturn(company);
        //when
        ResultActions perform = mockMvc.perform(
                post("/company")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(companyCreateRequest))
        );

        ConstrainedFields requestFields = new ConstrainedFields(CompanyCreateRequest.class);
        ConstrainedFields responseFields = new ConstrainedFields(CompanyCreateResponse.class);
        //then

        perform.andDo(
                MockMvcRestDocumentationWrapper.document(
                        "{class-name}/{method-name}", // identifier
                        Preprocessors.preprocessRequest(Preprocessors.prettyPrint()),
                        Preprocessors.preprocessResponse(Preprocessors.prettyPrint()),
                        resource(resourceBuilder
                                .summary("알림 수정")
                                .description("update 정보를 통해 알림을 업데이트할 수 있다.")
                                .requestFields(
                                        requestFields.withPath("companyName").type(JsonFieldType.STRING).description("company name"),
                                        requestFields.withPath("address").type(JsonFieldType.STRING).description("company address")
                                ).responseFields(
                                        responseFields.withPath("id").type(JsonFieldType.NUMBER).description("created company id"),
                                        responseFields.withPath("companyName").type(JsonFieldType.STRING).description("created company name"),
                                        responseFields.withPath("companyAddress").type(JsonFieldType.STRING).description("created company address")
                                )
                                .requestSchema(Schema.schema("CompanyCreateRequest"))
                                .responseSchema(Schema.schema("CompanyCreateResponse"))
                                .build())
                ));
    }
}