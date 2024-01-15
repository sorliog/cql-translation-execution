library "imm" version '1'

using FHIR version '4.0.1'

include "FHIRHelpers" version '4.0.1' called FHIRHelpers

codesystem "RXNORM": 'http://www.nlm.nih.gov/research/umls/rxnorm'

code "mmr code": '7271275' from "RXNORM" display 'mmr'


parameter Imm Immunization

context Patient


define function ToCode(coding FHIR.Coding):
  System.Code {
    code: coding.code.value,
    system: coding.system.value,
    version: coding.version.value,
    display: coding.display.value
  }


define "GetVaccineCode":
    Imm P
    return ToCode(P.vaccineCode.coding[0])
define "ProcessVaccineCode":
    Imm P
    return "GetVaccineCode" ~ "mmr code"

define "InPopulation":
  if "ProcessVaccineCode" then true
      else false

