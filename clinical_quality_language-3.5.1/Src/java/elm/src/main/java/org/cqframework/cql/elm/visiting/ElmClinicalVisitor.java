package org.cqframework.cql.elm.visiting;

import org.hl7.elm.r1.*;

/**
 * This interface defines a complete generic visitor for an Elm tree
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * @param <C> The type of context passed to each visit method
 * operations with no return type.
 */
public interface ElmClinicalVisitor<T, C> extends ElmVisitor<T, C> {

    /**
     * Visit a CodeFilterElement. This method will be called for
     * every node in the tree that is a CodeFilterElement.
     *
     * @param elm     the ELM tree
     * @param context the context passed to the visitor
     * @return the visitor result
     */
    T visitCodeFilterElement(CodeFilterElement elm, C context);

    /**
     * Visit a DateFilterElement. This method will be called for
     * every node in the tree that is a DateFilterElement.
     *
     * @param elm     the ELM tree
     * @param context the context passed to the visitor
     * @return the visitor result
     */
    T visitDateFilterElement(DateFilterElement elm, C context);

    /**
     * Visit an OtherFilterElement. This method will be called for
     * every node in the tree that is an OtherFilterElement.
     *
     * @param elm     the ELM tree
     * @param context the context passed to the visitor
     * @return the visitor result
     */
    T visitOtherFilterElement(OtherFilterElement elm, C context);

    /**
     * Visit an IncludeElement. This method will be called for
     * every node in the tree that is an IncludeElement.
     *
     * @param elm     the ELM tree
     * @param context the context passed to the visitor
     * @return the visitor result
     */
    T visitIncludeElement(IncludeElement elm, C context);

    /**
     * Visit a Retrieve. This method will be called for
     * every node in the tree that is a Retrieve.
     *
     * @param elm the ELM tree
     * @param context the context passed to the visitor
     * @return the visitor result
     */
    T visitRetrieve(Retrieve elm, C context);

    /**
     * Visit a Search. This method will be called for
     * every node in the tree that is a Search.
     *
     * @param elm     the ELM tree
     * @param context the context passed to the visitor
     * @return the visitor result
     */
    T visitSearch(Search elm, C context);

    /**
     * Visit a CodeSystemDef. This method will be called for
     * every node in the tree that is a CodeSystemDef.
     *
     * @param elm the ELM tree
     * @param context the context passed to the visitor
     * @return the visitor result
     */
    T visitCodeSystemDef(CodeSystemDef elm, C context);

    /**
     * Visit a ValueSetDef. This method will be called for
     * every node in the tree that is a ValueSetDef.
     *
     * @param elm the ELM tree
     * @param context the context passed to the visitor
     * @return the visitor result
     */
    T visitValueSetDef(ValueSetDef elm, C context);

    /**
     * Visit a CodeDef. This method will be called for
     * every node in the tree that is a CodeDef.
     *
     * @param elm     the ELM tree
     * @param context the context passed to the visitor
     * @return the visitor result
     */
    T visitCodeDef(CodeDef elm, C context);

    /**
     * Visit an ConceptDef. This method will be called for
     * every node in the tree that is an ConceptDef.
     *
     * @param elm     the ELM tree
     * @param context the context passed to the visitor
     * @return the visitor result
     */
    T visitConceptDef(ConceptDef elm, C context);

    /**
     * Visit a CodeSystemRef. This method will be called for
     * every node in the tree that is a CodeSystemRef.
     *
     * @param elm the ELM tree
     * @param context the context passed to the visitor
     * @return the visitor result
     */
    T visitCodeSystemRef(CodeSystemRef elm, C context);

    /**
     * Visit a ValueSetRef. This method will be called for
     * every node in the tree that is a ValueSetRef.
     *
     * @param elm the ELM tree
     * @param context the context passed to the visitor
     * @return the visitor result
     */
    T visitValueSetRef(ValueSetRef elm, C context);

    /**
     * Visit a CodeRef. This method will be called for
     * every node in the tree that is a CodeRef.
     *
     * @param elm     the ELM tree
     * @param context the context passed to the visitor
     * @return the visitor result
     */
    T visitCodeRef(CodeRef elm, C context);

    /**
     * Visit a ConceptRef. This method will be called for
     * every node in the tree that is a ConceptRef.
     *
     * @param elm     the ELM tree
     * @param context the context passed to the visitor
     * @return the visitor result
     */
    T visitConceptRef(ConceptRef elm, C context);

    /**
     * Visit a Code. This method will be called for
     * every node in the tree that is a Code.
     *
     * @param elm the ELM tree
     * @param context the context passed to the visitor
     * @return the visitor result
     */
    T visitCode(Code elm, C context);

    /**
     * Visit a Concept. This method will be called for
     * every node in the tree that is a Concept.
     *
     * @param elm the ELM tree
     * @param context the context passed to the visitor
     * @return the visitor result
     */
    T visitConcept(Concept elm, C context);

    /**
     * Visit a InCodeSystem. This method will be called for
     * every node in the tree that is a InCodeSystem.
     *
     * @param elm the ELM tree
     * @param context the context passed to the visitor
     * @return the visitor result
     */
    T visitInCodeSystem(InCodeSystem elm, C context);

    /**
     * Visit an AnyInCodeSystem. This method will be called for
     * every node in the tree that is an AnyInCodeSystem.
     *
     * @param elm     the ELM tree
     * @param context the context passed to the visitor
     * @return the visitor result
     */
    T visitAnyInCodeSystem(AnyInCodeSystem elm, C context);

    /**
     * Visit a InValueSet. This method will be called for
     * every node in the tree that is a InValueSet.
     *
     * @param elm the ELM tree
     * @param context the context passed to the visitor
     * @return the visitor result
     */
    T visitInValueSet(InValueSet elm, C context);

    /**
     * Visit an AnyInValueSet. This method will be called for
     * every node in the tree that is an AnyInValueSet.
     *
     * @param elm     the ELM tree
     * @param context the context passed to the visitor
     * @return the visitor result
     */
    T visitAnyInValueSet(AnyInValueSet elm, C context);

    /**
     * Visit an Subsumes. This method will be called for
     * every node in the tree that is an Subsumes.
     *
     * @param elm     the ELM tree
     * @param context the context passed to the visitor
     * @return the visitor result
     */
    T visitSubsumes(Subsumes elm, C context);

    /**
     * Visit an SubsumedBy. This method will be called for
     * every node in the tree that is an SubsumedBy.
     *
     * @param elm     the ELM tree
     * @param context the context passed to the visitor
     * @return the visitor result
     */
    T visitSubsumedBy(SubsumedBy elm, C context);

    /**
     * Visit a Quantity. This method will be called for
     * every node in the tree that is a Quantity.
     *
     * @param elm the ELM tree
     * @param context the context passed to the visitor
     * @return the visitor result
     */
    T visitQuantity(Quantity elm, C context);

    /**
     * Visit a Ratio. This method will be called for
     * every node in the tree that is a Ratio.
     *
     * @param elm     the ELM tree
     * @param context the context passed to the visitor
     * @return the visitor result
     */
    T visitRatio(Ratio elm, C context);

    /**
     * Visit a CalculateAge. This method will be called for
     * every node in the tree that is a CalculateAge.
     *
     * @param elm the ELM tree
     * @param context the context passed to the visitor
     * @return the visitor result
     */
    T visitCalculateAge(CalculateAge elm, C context);

    /**
     * Visit a CalculateAgeAt. This method will be called for
     * every node in the tree that is a CalculateAgeAt.
     *
     * @param elm the ELM tree
     * @param context the context passed to the visitor
     * @return the visitor result
     */
    T visitCalculateAgeAt(CalculateAgeAt elm, C context);
}
