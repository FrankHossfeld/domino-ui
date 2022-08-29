package org.dominokit.domino.ui.forms;

import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLInputElement;
import org.dominokit.domino.ui.forms.validations.MaxLengthValidator;
import org.dominokit.domino.ui.forms.validations.MinLengthValidator;
import org.dominokit.domino.ui.utils.*;

import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.forms.FormsStyles.FIELD_COUNTER;

public abstract class TextInputFormField<T extends InputFormField<T, E, V>, E extends HTMLInputElement, V>
        extends InputFormField<T, E, V>
        implements HasCounter<T>, HasMinMaxLength<T>, HasPlaceHolder<T> {

    protected final LazyChild<DominoElement<HTMLElement>> counterElement;
    protected CountFormatter countFormatter = (count, maxCount) -> count + "/" + maxCount;
    private MinLengthValidator<T> minLengthValidator;
    private MaxLengthValidator<T> maxLengthValidator;

    public TextInputFormField() {
        counterElement = LazyChild.of(DominoElement.span().addCss(FIELD_COUNTER), wrapperElement);
    }

    @Override
    public T updateCounter(int count, int maxCount) {
        counterElement.get().setTextContent(countFormatter.format(count, getMaxCount()));
        minLengthValidator = new MinLengthValidator<>(this);
        maxLengthValidator = new MaxLengthValidator<>(this);
        return (T) this;
    }

    public T setCountFormatter(CountFormatter formatter) {
        this.countFormatter = formatter;
        return (T) this;
    }

    @Override
    public int getMaxLength() {
        if (getInputElement().hasAttribute(MAX_LENGTH)) {
            return Integer.parseInt(getInputElement().getAttribute(MAX_LENGTH));
        }
        return -1;
    }

    @Override
    public T setMaxLength(int maxLength) {
        if (maxLength < 0) {
            counterElement.remove();
            getInputElement().removeAttribute(MAX_LENGTH);
            removeValidator(maxLengthValidator);
        } else {
            counterElement.get();
            getInputElement().setAttribute(MAX_LENGTH, maxLength);
            updateCounter(getLength(), getMaxCount());
            addValidator(maxLengthValidator);
        }
        return (T) this;
    }

    @Override
    public int getLength() {
        String stringValue = getStringValue();
        if (nonNull(stringValue)) {
            return getStringValue().length();
        }
        return 0;
    }

    @Override
    public int getMinLength() {
        if (getInputElement().hasAttribute(MIN_LENGTH)) {
            return Integer.parseInt(getInputElement().getAttribute(MIN_LENGTH));
        }
        return -1;
    }

    @Override
    public T setMinLength(int minLength) {
        if (minLength < 0) {
            counterElement.remove();
            getInputElement().removeAttribute(MIN_LENGTH);
            removeValidator(minLengthValidator);
        } else {
            counterElement.get();
            getInputElement().setAttribute("minlength", minLength);
            updateCounter(getLength(), getMaxCount());
            addValidator(minLengthValidator);
        }
        getInputElement().setAttribute(MIN_LENGTH, minLength);
        return (T) this;
    }

    @Override
    public int getMaxCount() {
        return getMaxLength();
    }

    @Override
    public String getPlaceholder() {
        return getInputElement().getAttribute("placeholder");
    }

    @Override
    public T setPlaceholder(String placeholder) {
        getInputElement().setAttribute("placeholder", placeholder);
        return (T) this;
    }

    public DominoElement<HTMLElement> getCounterElement() {
        return counterElement.get();
    }

    public T withCounterElement() {
        counterElement.get();
        return (T) this;
    }

    public T withCounterElement(ChildHandler<T, DominoElement<HTMLElement>> handler) {
        handler.apply((T) this, counterElement.get());
        return (T) this;
    }
}
