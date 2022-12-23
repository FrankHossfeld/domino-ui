/*
 * Copyright © 2019 Dominokit
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.dominokit.domino.ui.notifications;

import static java.util.Objects.nonNull;

import elemental2.dom.*;

import java.util.ArrayList;
import java.util.List;

import org.dominokit.domino.ui.animations.Animation;
import org.dominokit.domino.ui.animations.Transition;
import org.dominokit.domino.ui.button.RemoveButton;
import org.dominokit.domino.ui.style.*;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.LazyChild;
import org.jboss.elemento.EventType;

/**
 * A component for showing notifications on different position with custom content
 *
 * <p>Customize the component can be done by overwriting classes provided by {@link
 * NotificationStyles}
 *
 * <p>For example:
 *
 * <pre>
 *     Notification.createSuccess("Everything is okay");
 * </pre>
 *
 * @see BaseDominoElement
 */
public class Notification extends BaseDominoElement<HTMLDivElement, Notification>
        implements NotificationStyles {

    /**
     * Top left position
     */
    public static final Position TOP_LEFT = new TopLeftPosition();
    /**
     * Top center position
     */
    public static final Position TOP_CENTER = new TopCenterPosition();
    /**
     * Top right position
     */
    public static final Position TOP_RIGHT = new TopRightPosition();
    /**
     * Bottom left position
     */
    public static final Position BOTTOM_LEFT = new BottomLeftPosition();
    /**
     * Bottom center position
     */
    public static final Position BOTTOM_CENTER = new BottomCenterPosition();
    /**
     * Bottom right position
     */
    public static final Position BOTTOM_RIGHT = new BottomRightPosition();

    private final DominoElement<HTMLDivElement> element;
    private final DominoElement<HTMLDivElement> root;
    private final LazyChild<DominoElement<HTMLElement>> messageSpan;
    private final LazyChild<RemoveButton> closeButton;

    private int duration = 4000;
    private Transition[] inTransitions = new Transition[]{Transition.FADE_IN};
    private Transition[] outTransitions = new Transition[]{Transition.FADE_OUT};
    private SwapCssClass position = SwapCssClass.of(dui_ntf_top_left);
    private boolean closable = true;
    private boolean infinite = false;
    private boolean closed = true;
    private final List<CloseHandler> closeHandlers = new ArrayList<>();

    public Notification() {
        root = DominoElement.div()
                .addCss(dui_notification_wrapper, position)
                .appendChild(element = DominoElement.div().addCss(dui_notification));
        messageSpan = LazyChild.of(DominoElement.span(), element);
        closeButton = LazyChild.of(RemoveButton.create(), element);
        closeButton.whenInitialized(() -> {
            closeButton.element().addEventListener(EventType.click.getName(), e -> close());
            element.insertBefore(DominoElement.span().addCss("dui-notification-filler"), closeButton.element());
        });
        init(this);
    }

    /**
     * Creates a notification for the message with no specific type and default black bacjground.
     *
     * @param message the content message
     * @return {@link Notification}
     */
    public static Notification create(String message) {
        Notification notification = new Notification();
        notification.setMessage(message);
        return notification;
    }

    @Override
    protected HTMLElement getStyleTarget() {
        return element.element();
    }

    @Override
    protected HTMLElement getAppendTarget() {
        return element.element();
    }

    /**
     * @return {@link DominoElement<HTMLButtonElement>} the close button of the notification.
     */
    public RemoveButton getCloseButton() {
        return closeButton.get();
    }

    /**
     * Use to show or hide the close button.
     *
     * @return {@link Notification}
     */
    public Notification setClosable(boolean closable) {
        this.closable = closable;
        closeButton.initOrRemove(closable);
        return this;
    }

    /**
     * @return boolean, true if the close button is visible, else false.
     */
    public boolean isClosable() {
        return closable;
    }

    /**
     * for none infinite notifications, the duration defined how long the notification will remain
     * visible after the show transition is completed before it is automatically closed.
     *
     * @param duration in millisecond
     * @return {@link Notification}
     */
    public Notification duration(int duration) {
        this.duration = duration;
        return this;
    }

    /**
     * Defines the animation transition to be applied to show up the notification when {@link
     * Notification#show()} is called.
     *
     * @param inTransitions {@link Transition}
     * @return {@link Notification}
     */
    public Notification inTransition(Transition... inTransitions) {
        this.inTransitions = inTransitions;
        return this;
    }

    /**
     * Defines the animation transition to be applied to close up the notification when {@link
     * Notification#close()} is called, or the duration ends.
     *
     * @param outTransitions {@link Transition}
     * @return {@link Notification}
     */
    public Notification outTransition(Transition... outTransitions) {
        this.outTransitions = outTransitions;
        return this;
    }

    /**
     * The text content of the notification
     *
     * @param message the content message
     * @return {@link Notification}
     */
    public Notification setMessage(String message) {
        this.messageSpan.get().setTextContent(message);
        return this;
    }

    /**
     * Defines the location in which the notification will show up when {@link Notification#show()} is
     * called.
     *
     * @param position {@link Position}
     * @return {@link Notification}
     */
    public Notification setPosition(CssPosition position) {
        root.addCss(this.position.replaceWith(position.style));
        return this;
    }

    /**
     * When true, duration will be ignored, and the notification will only close if the {@link
     * Notification#close()} is called or close button is clicked.
     *
     * @param infinite true to close manually only, false otherwise
     * @return {@link Notification}
     */
    public Notification setInfinite(boolean infinite) {
        this.infinite = infinite;
        return this;
    }

    /**
     * @return boolean, true if notification is finite
     */
    public boolean isInfinite() {
        return infinite;
    }

    /**
     * Show up the notification and apply the IN transtion animation.
     *
     * @return {@link Notification}
     */
    public Notification show() {
        this.closed = false;
        Animation.create(element)
                .beforeStart(element -> DomGlobal.document.body.appendChild(element()))
                .transition(inTransitions)
                .callback(
                        e -> {
                            if (!infinite) {
                                close(duration);
                            }
                        })
                .animate();
        return this;
    }

    /**
     * Closes the notification based on the applied notification position and apply the close
     * animation.ce trans
     */
    public final void close() {
        close(0);
    }

    /**
     * Closes the notification based on the applied notification position and apply the close
     * animation after the specified duration.
     *
     * @param after time to wait before starting the close animation in milliseconds
     */
    public final void close(int after) {
        if (!closed) {
            animateClose(
                    after,
                    () -> {
                        closeHandlers.forEach(CloseHandler::onClose);
                        this.closed = true;
                    });
        }
    }

    private void animateClose(int after, Runnable onComplete) {
        Animation.create(element)
                .delay(after)
                .transition(outTransitions)
                .callback(
                        e2 -> {
                            element().remove();
                            onComplete.run();
                        })
                .animate();
    }

    /**
     * @return List of {@link CloseHandler} to be called when a notification is closed.
     */
    public List<CloseHandler> getCloseHandlers() {
        return closeHandlers;
    }

    /**
     * Add a handler to be called when a notification is closed
     *
     * @param closeHandler {@link CloseHandler}
     * @return {@link Notification}
     */
    public Notification addCloseHandler(CloseHandler closeHandler) {
        if (nonNull(closeHandler)) {
            closeHandlers.add(closeHandler);
        }
        return this;
    }

    /**
     * Removes a {@link CloseHandler} from the currently existing close handlers.
     *
     * @param closeHandler A {@link CloseHandler}
     * @return {@link Notification}
     */
    public Notification removeCloseHandler(CloseHandler closeHandler) {
        if (nonNull(closeHandler)) {
            closeHandlers.remove(closeHandler);
        }
        return this;
    }

    /**
     * @return {@link HTMLDivElement} the root element that represent this notification instance.
     */
    @Override
    public HTMLDivElement element() {
        return root.element();
    }

    /**
     * An interface for the required API to implement new position classes for notifications
     */
    public interface Position {
        /**
         * this method will be called before attaching the notification element to the dom.
         *
         * @param element the notification element
         */
        void onBeforeAttach(HTMLElement element);

        /**
         * this method will be called everytime we try to show a new notification.
         *
         * @param element the notification element
         */
        void onNewElement(HTMLElement element);

        /**
         * this method will be called once the notification is completed and the notification element is
         * removed from the dom
         *
         * @param dataPosition
         * @param height
         */
        void onRemoveElement(int dataPosition, int height);
    }

    /**
     * functional interface to handle close event
     */
    @FunctionalInterface
    public interface CloseHandler {
        void onClose();
    }

    public enum CssPosition {
        TOP_LEFT(NotificationStyles.dui_ntf_top_left),
        TOP_MIDDLE(NotificationStyles.dui_ntf_top_middle),
        TOP_RIGHT(NotificationStyles.dui_ntf_top_right),
        BOTTOM_LEFT(NotificationStyles.dui_ntf_bottom_left),
        BOTTOM_MIDDLE(NotificationStyles.dui_ntf_bottom_middle),
        BOTTOM_RIGHT(NotificationStyles.dui_ntf_bottom_right)
        ;

        private CssClass style;

        CssPosition(CssClass style) {
            this.style = style;
        }

        public CssClass getStyle() {
            return style;
        }
    }
}
